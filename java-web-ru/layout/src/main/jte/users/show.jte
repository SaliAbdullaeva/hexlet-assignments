@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
header = @`
    <p>
        <a href="/" class="btn btn-primary">Main page</a>
        <a href="/users" class="btn btn-primary">Users</a>
    </p>
`,
content = @`
    @if(page == null)
        <p>User not found!</p>
    @else
        <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <p>${page.getUser().getEmail()}</p>
    @endif
`,
footer = @`
    <p>GrandV Ltd.</p>
`
)
