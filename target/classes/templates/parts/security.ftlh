<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isRegistrationForm=false
    currentUserId = user.getId()
    usN=user.is1()
    <#--isTask=user.isTask()-->
    >
<#else>
    <#assign    <#-- для неавторизованного-->
    name = "unknown"
    isAdmin = false
    isRegistrationForm=true
    currentUserId = -1
    usN=false
    <#--isTask=false-->
    >
</#if>