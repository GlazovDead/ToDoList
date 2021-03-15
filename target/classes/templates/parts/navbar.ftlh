<#include "security.ftlh">
<#import "login1.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">ToDoList</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if user??> <#--если юзер есть, то показываем:-->
                <li class="nav-item">
                    <a class="nav-link" href="/userTasks/${currentUserId}">MyTasks</a>
                </li>
            <#-- <a class="nav-link" href="/user-messages/${currentUserId}">-->
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Profile</a>
                </li>
            </#if>
            <#if isRegistrationForm>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Sign Up</a>
                </li>
            </#if>
            <#if isRegistrationForm>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Sign In</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if user??>
            <@l.logout />
        </#if>

    </div>
</nav>