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
                <p class="card-text">${resume.contact.contactType}: <b>${resume.contact.contactValue}</b></p>
                <p class="card-text">Требуемая заработная плата от: <b>${resume.requiredSalary}</b> сом</p>
                <#list resume.experiences as experiences>
                    <hr>
                    <h5 class="card-title">Опыты</h5>
                    <li>Компания: ${experiences.companyName}</li>
                    <li>Обязанности: ${experiences.responsibilities}</li>
                    <li>Срок работы: ${experiences.workPeriod}</li>
                </#list>
                <#list resume.educations as education>
                    <hr>
                    <h5 class="card-title">Образования</h5>
                    <li>Образование: ${education.education}</li>
                    <li>Место обучения: ${education.placeOfStudy}</li>
                    <li>Период обучения: ${education.studyPeriod}</li>
                </#list>
            </div>
            <div class="card-footer text-muted">
                <#if resume.dateOfUpdated??>
                    <p class="card-text"><small class="text-muted">Дата
                            обновления: ${resume.dateOfUpdated}</small></p>
                <#else>
                    <p class="card-text"><small class="text-muted">Дата
                            добавления: ${resume.dateOfPosted}</small></p>
                </#if>
            </div>
        </div>
    </#list>
</@main.layout>