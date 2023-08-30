<#import "../layout.ftlh" as main>
<@main.layout>
    <a href="/new/education/${resume.id}" type="button" id="add-education-button" class="btn btn-dark">Add education</a>
    <a href="/new/experience/${resume.id}" type="button" id="add-education-button" class="btn btn-dark">Add experience</a>


    <form action="/resume/change/${resume.id}" method="post" id="create-resume" style="margin-top: 20px">
        <div class="form-group">
            <input type="text" class="form-control" name="title" id="title" aria-describedby="nameHelp"
                   placeholder="Resume title" required>
        </div>
        <div class="form-group">
            <input type="number" class="form-control" name="requiredSalary" id="surname" aria-describedby="emailHelp"
                   placeholder="Required salary">
        </div>
        <select class="form-control required" name="contact.contactType" id="contactType" required
                style="margin-bottom: 20px">
            <option disabled selected value="">Select contact type</option>
            <option>EMAIL</option>
            <option>FACEBOOK_LINK</option>
            <option>LINKEDIN_LINK</option>
            <option>PHONE_NUMBER</option>
            <option>TELEGRAM</option>
        </select>
        <div class="form-group">
            <input type="text" class="form-control" name="contact.contactValue" id="contactValue"
                   aria-describedby="emailHelp"
                   placeholder="Contact">
        </div>
        <select class="form-control required" name="category" id="category" required>
            <option disabled selected value="">Select category</option>
            <#list categories as category>
                <option>${category.title}</option>
            </#list>
        </select>
        <button type="submit" class="btn btn-dark" style="margin-top: 20px">Submit</button>
    </form>
</@main.layout>