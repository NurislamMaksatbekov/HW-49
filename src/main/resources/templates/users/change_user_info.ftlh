    <#import "../layout.ftlh" as main>
    <@main.layout>
        <form action="/users/change" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="name" id="name" aria-describedby="nameHelp" placeholder="First Name" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="surname" id="surname" aria-describedby="emailHelp" placeholder="Second name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control required" name="username" id="username" aria-describedby="emailHelp" placeholder="Username" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
</@main.layout>