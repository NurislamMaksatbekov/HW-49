<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/users/register" method="post">
        <div class="form-group">
            <input type="text" class="form-control required" id="name" aria-describedby="nameHelp" placeholder="First Name">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="surname" aria-describedby="emailHelp" placeholder="Second name">
        </div>
        <div class="form-group">
            <input type="text" class="form-control required" id="username" aria-describedby="emailHelp" placeholder="Username">
        </div>
        <div class="form-group">
            <input type="email" class="form-control required" id="email" aria-describedby="emailHelp" placeholder="Email address">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <input type="password" class="form-control required" id="password" placeholder="Password">
        </div>
        <div class="form-group">
            <input type="number" class="form-control required" id="phoneNumber" placeholder="Phone number">
        </div>

        <div class="form-group required">
            <label for="exampleFormControlSelect1">Who are you?</label>
            <select class="form-control required" id="exampleFormControlSelect1" required>
                <option disabled selected value="">Select type of account</option>
                <option>EMPLOYER</option>
                <option>APPLICANT</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</@main.layout>