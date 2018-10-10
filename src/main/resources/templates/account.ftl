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
    <H3>Счетчики:</H3>
<div>
    <a class="btn btn-primary btn-xs" href="/account/${account.account_number}/counter/new" role="button">Добавить счетчик</a>
</div>
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
    </div>
    <#else>
    Указанный Л/С не найден
    </#if>

</@c.page>
