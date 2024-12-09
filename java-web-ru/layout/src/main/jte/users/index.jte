@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page

@template.layout.page(
header = @`
    <p>
        <a href="/" class="btn btn-primary">Main page</a>
    </p>
`,
content = @`
    @if(page == null)
        <p>User list not found!</p>
    @else
        @for(User user : page.getUsers())
            <p>
                <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
            </p>
        @endfor
    @endif
`,
footer = @`
    <p>GrandV Ltd.</p>
`
)