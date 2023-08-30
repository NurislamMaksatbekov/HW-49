<#import "../layout.ftlh" as main>
<@main.layout>
        <div class="card text-center"  style="margin-top: 50px">
            <div class="card-header">
                Вакансию опубликовала компания: <h4>${vacancy.authorEmail}</h4>
            </div>
            <div class="card-body">
                <h5 class="card-title">Название работы: ${vacancy.title}</h5>
                <p class="card-text">Описание работы: ${vacancy.jobDescription}</p>
                <p class="card-text">Требуемый опыт от <b>${vacancy.requiredMinExperience}</b> до <b>${vacancy.requiredMaxExperience}</b></p>
                <p class="card-text">3аработная плата от: <b>${vacancy.salary}</b> сом</p>
                <a href="#" class="btn btn-primary">Откликнутся</a>
            </div>
            <div class="card-footer text-muted">
                <#if vacancy.dateOfUpdated??>
                    <p class="card-text"><small class="text-muted">Дата
                            обновления: ${vacancy.dateOfUpdated.getMonth()} ${vacancy.dateOfUpdated.getDayOfMonth()}</small></p>
                <#else>
                    <p class="card-text"><small class="text-muted">Дата
                            добавления: ${vacancy.dateOfPosted.getMonth()} ${vacancy.dateOfUpdated.getDayOfMonth()}</small></p>
                </#if>
            </div>
        </div>
</@main.layout>