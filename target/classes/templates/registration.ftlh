<#import "parts/common.ftlh" as c>
<#import "parts/login1.ftlh" as l>
<@c.page>
    <div class="mb-1">Add new user</div>
    ${task!""}
    <@l.login "/registration" true/>
</@c.page>