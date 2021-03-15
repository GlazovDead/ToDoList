<#include "security.ftlh">

<div class="card-columns">
    <#list tasks as task>
        <#if task.author.id==currentUserId>
            <div class="card my-3">
                <div class="m-2">
                    <span>${task.text}</span><br/>
                    <a>${task.timer} min</a>
                </div>
                <div class="card-footer text-muted">
                    <a href="/user/profile">${task.authorName}</a>
                    <#if task.author.id==currentUserId>
                        <a class="btn btn-primary" href="/userTasks/${task.author.id}/${task.id}">
                            Edit
                        </a>
                    </#if>

                </div>
                <div>
                    <form method="post" action="/userTasks/${task.author.id}/delete/${task.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input type="submit" value="Complete task!">
                    </form>
                </div>
            </div>
        </#if>
    <#else>
        No tasks
    </#list>
</div>
