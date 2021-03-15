<#import "parts/common.ftlh" as c>
<#import "parts/common.ftlh" as c>
<#import "parts/login1.ftlh" as l>
<@c.page>
    <div class="mb-1">Sign in</div>
    ${task!""}
    <@l.login "/login" false/>
</@c.page>