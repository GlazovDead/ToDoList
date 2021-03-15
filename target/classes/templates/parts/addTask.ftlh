<#include "security.ftlh">
<div>
    <form method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if task??>${task.text}</#if>" name="text" placeholder="Введите сообщение"/>
            </label>
        </div>
        <div class="form-group">
            <label>
                <input type="text" class="form-control  ${(textError??)?string('is-invalid', '')}"
                       value="<#if task??>${task.timer}</#if>" name="timer" placeholder="Сколько времени на цель?"/>
            </label>

        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="<#if task??>${task.id}</#if>"/>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Create task!</button>
        </div>
    </form>
</div>