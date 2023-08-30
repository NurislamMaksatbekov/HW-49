<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/new/education/${resume.id}" method="post" style="margin-top: 20px">
        <div class="form-group">
            <input type="text" class="form-control" name="education" id="title" aria-describedby="nameHelp"
                   placeholder="Education" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="placeOfStudy" id="surname" aria-describedby="emailHelp"
                   placeholder="Place of study">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="studyPeriod" id="surname" aria-describedby="emailHelp"
                   placeholder="Study period">
        </div>
        <button type="submit" class="btn btn-dark" style="margin-top: 20px">Submit</button>
    </form>
</@main.layout>