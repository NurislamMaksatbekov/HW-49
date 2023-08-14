<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/users/register" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="name" id="name" aria-describedby="nameHelp" placeholder="First Name" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="surname" id="surname" aria-describedby="emailHelp" placeholder="Second name">
        </div>
        <div class="form-group">
            <input type="text" class="form-control required" name="username" id="username" aria-describedby="emailHelp" placeholder="Username" required>
        </div>
        <div class="form-group">
            <input type="email" class="form-control required" name="email" id="email" aria-describedby="emailHelp" placeholder="Email address" required>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <input type="password" class="form-control required" name="password" id="password" placeholder="Password" required>
        </div>
        <div class="form-group">
            <input type="number" class="form-control required" name="phoneNumber" id="phoneNumber" placeholder="Phone number" required>
        </div>

        <div class="form-group required">
            <label for="exampleFormControlSelect1">Who are you?</label>
            <select class="form-control required" name="accountType" id="accountType" required>
                <option disabled selected value="">Select type of account</option>
                <option>EMPLOYER</option>
                <option>APPLICANT</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</@main.layout>