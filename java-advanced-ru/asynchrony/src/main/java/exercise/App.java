package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String outputFile) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            Path filePath = Paths.get(file1).toAbsolutePath();
            try {
                return Files.readString(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            Path filePath = Paths.get(file2).toAbsolutePath();
            try {
                return Files.readString(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return future1.thenCombine(future2, (text1, text2) -> {
            Path filePath = Paths.get(outputFile).toAbsolutePath();
            try {
                Files.writeString(filePath, text1 + text2, StandardOpenOption.CREATE);
                return text1 + " " + text2;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String path) {
        var directory = new File(path);
        if (!directory.isDirectory()) {
            return CompletableFuture.completedFuture(0L);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return CompletableFuture.completedFuture(0L);
        }

        CompletableFuture<Long>[] fileSizes = Arrays.stream(files)
                .filter(File::isFile)
                .map(file -> CompletableFuture.supplyAsync(file::length))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(fileSizes)
                .thenApply(v -> Arrays.stream(fileSizes)
                        .mapToLong(CompletableFuture::join)
                        .sum());
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        String resultText = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt"
        ).get();
        CompletableFuture<Long> size = getDirectorySize("src/main/resources");
        System.out.println(resultText);
        System.out.println(size.get());
        // END
    }
}

