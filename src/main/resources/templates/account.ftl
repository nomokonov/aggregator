<#import "parts/common.ftl" as c>

<@c.page>
    <#if account??>
<H1>Данные по Л/С № ${account.account_number}</H1>

<div class="card-columns">
    <div class="card my-3">
        <div class="m-2">
            <span>${account.account_name}</span>
        </div>
        <div class="card-footer text-muted">
            <span>${account.lastname} ${account.firstname} ${account.patronymic}</span>
            <p>${account.account_address}</p>
        </div>
        <div>
            <a class="btn btn-secondary btn-xs btn-block" href="/account/${account.id}/edit" role="button">Редактировать</a>
        </div>
    </div>

</div>
    <#else>
    Указанный Л/С не найден
    </#if>

</@c.page>
