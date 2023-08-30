<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/new/experience/${resume.id}" method="post" id="create-resume" style="margin-top: 20px">
        <div class="form-group">
            <input type="text" class="form-control" name="companyName" id="title" aria-describedby="nameHelp"
                   placeholder="Company name" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="workPeriod" id="surname" aria-describedby="emailHelp"
                   placeholder="Work Period">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="responsibilities" id="surname" aria-describedby="emailHelp"
                   placeholder="Responsibilities">
        </div>
        <button type="submit" class="btn btn-dark" style="margin-top: 20px">Submit</button>
    </form>
</@main.layout>