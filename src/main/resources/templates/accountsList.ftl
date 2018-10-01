<#import "parts/common.ftl" as c>

<@c.page>
<H1>Лицевые счета</H1>
<div>
    <a class="btn btn-primary btn-xs" href="/account/new" role="button">Создать л/с</a>
</div>
<div class="card-columns">
    <#list accounts as account>
        <div class="card my-3">
        <#if account.filename??>
        <img src="/img/${message.filename}" class="card-img-top">
        </#if>
            <a href="/account/${account.id} ">
                <div class="m-2">
                    <span>${account.account_name}</span>
                    <i>Л/С № ${account.account_number}</i>
                </div>
            </a>

            <div class="card-footer text-muted">
                <span>${account.lastname} ${account.firstname} ${account.patronymic}</span>
                <p>${account.account_address}</p>
            </div>
        </div>
    <#else>
    Нет ни одного лицевого счета
    </#list>
</div>

</@c.page>
