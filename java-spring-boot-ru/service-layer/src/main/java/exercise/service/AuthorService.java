package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> findAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO findById(long id) {
        var book = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id " + id + " not found"));
        return authorMapper.map(book);
    }

    public AuthorDTO create(AuthorCreateDTO authorData) {
        var book = authorMapper.map(authorData);
        authorRepository.save(book);
        return authorMapper.map(book);
    }

    public AuthorDTO update(long id, AuthorUpdateDTO authorData) {
        var book = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id " + id + " not found"));
        authorMapper.update(authorData, book);
        authorRepository.save(book);
        return authorMapper.map(book);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
