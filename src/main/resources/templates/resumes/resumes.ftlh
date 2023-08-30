<#import "../layout.ftlh" as main>
<@main.layout>
    <#list resumes as resume>
        <div class="card text-center"  style="margin-top: 50px">
            <div class="card-header">
                Резюме опубликовал: <h4>${resume.authorEmail}</h4>
            </div>
            <div class="card-body">
                <h5 class="card-title">Название резюме: ${resume.title}</h5>
                <p class="card-text">Категория работы: ${resume.category}</p>
                <p class="card-text">Требуемая заработная плата от: <b>${resume.requiredSalary}</b> сом</p>
                <a href="summary/${resume.id}" class="btn btn-primary">Подробнее</a>
            </div>
        </div>
    </#list>
</@main.layout>