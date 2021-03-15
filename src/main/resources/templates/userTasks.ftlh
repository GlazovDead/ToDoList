<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <#if user??>
        <#include "parts/addTask.ftlh"/>
        <#include "parts/taskList.ftlh"/>
    </#if>
</@c.page>