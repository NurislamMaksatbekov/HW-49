<#import "../layout.ftlh" as main>
<@main.layout>
    <#list vacancies as vacancy>
        <div class="card text-center"  style="margin-top: 50px">
            <div class="card-body">
                <h5 class="card-title">Название работы: ${vacancy.title}</h5>
                <p class="card-text">3аработная плата от: <b>${vacancy.salary}</b> сом</p>
                <a href="vacancy/${vacancy.id}" class="btn btn-primary">Подробнее</a>
            </div>
        </div>
    </#list>
</@main.layout>