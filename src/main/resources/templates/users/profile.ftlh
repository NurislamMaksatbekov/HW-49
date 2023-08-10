<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="card mb-3">
        <div class="row no-gutters">
            <div class="col-md-4">
                <img src="" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <#if user.accountType == "APPLICANT">
                        <h5 class="card-title">${user.name} ${user.surname}</h5>
                        <a href="" class="btn btn-dark">Редактировать</a>
                        <a href="" class="btn btn-dark" style="margin-left: 250px">Создать резюме</a>
                        <a href="" class="btn btn-dark" style="margin-left: 20px">Отклики</a>
                    <#else>
                        <h5 class="card-title">${user.name}</h5>
                        <a href="" class="btn btn-dark">Редактировать</a>
                        <a href="" class="btn btn-dark" style="margin-left: 250px">Создать вакансию</a>
                    </#if>
                </div>
            </div>
            <#if user.accountType == 'APPLICANT'>
                <#list resumes as resume>
                    <div class="card mr-auto ml-auto" style="width: 20rem; margin-top: 50px">
                        <div class="card-body">
                            <h5 class="card-title">${resume.title}</h5>
                            <#if resume.dateOfUpdated??>
                                <p class="card-text"><small class="text-muted">Дата
                                        обновления: ${resume.dateOfUpdated}</small></p>
                            <#else>
                                <p class="card-text"><small class="text-muted">Дата
                                        добавления: ${resume.dateOfPosted}</small></p>
                            </#if>
                            <a href="" class="btn btn-dark">Обновить</a>
                            <a href="" class="btn btn-dark">Редактировать</a>
                        </div>
                    </div>
                </#list>
            <#else>
                <#list vacancies as vacancy>
                    <div class="card mr-auto ml-auto" style="width: 20rem; margin-top: 50px">
                        <div class="card-body">
                            <h5 class="card-title">${vacancy.title}</h5>
                            <#if vacancy.dateOfUpdated??>
                                <p class="card-text"><small class="text-muted">Дата
                                        обновления: ${vacancy.dateOfUpdated}</small></p>
                            <#else>
                                <p class="card-text"><small class="text-muted">Дата
                                        добавления: ${vacancy.dateOfPosted}</small></p>
                            </#if>
                            <a href="" class="btn btn-dark">Обновить</a>
                            <a href="" class="btn btn-dark">Редактировать</a>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>
    </div>
</@main.layout>