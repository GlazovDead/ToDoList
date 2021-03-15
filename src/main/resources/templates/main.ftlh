<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <#if isRegistrationForm>
        Please, Sign in or Sign up
    <#else>
        Create your task!

    </#if>
    <#--<#if isTask>
        User tasks
        <#include "parts/taskList.ftlh"/>
        <#else>
        Create your first task!
    </#if>-->


</@c.page>