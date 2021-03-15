<#import "parts/common.ftlh" as c>
<@c.page>
    Task Editor
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if task??>${task.text}</#if>" name="text" placeholder="Введите цель"/>
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if task??>${task.timer}</#if>" name="timer" placeholder="Время выполнения">
                <#if timerError??>
                    <div class="invalid-feedback">
                        ${timerError}
                    </div>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="<#if task??>${task.id}</#if>"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save message</button>
            </div>
        </form>
    </div>
</@c.page>
