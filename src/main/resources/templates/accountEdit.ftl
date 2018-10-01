<#import "parts/common.ftl" as c>

<@c.page>
<#if action == "new">
<H2>Создание Лицевого счета (Л/С)</H2>
<form action="/account/add" method="post"  class="container"  >
</#if>
<#if action == "edit">
<H2>Редактирование Л/С № ${account.account_number! }</H2>
<form action="/account/${account.id!}/save" method="post"  class="container"  >
</#if>

            <div class="form-group">
                <label for="account_name_input" >Наимнование Л/С</label>

                <input class="form-control"  type="text" name="account_name" value="${account.account_name!}" placeholder="Наимнование Л/С" id="account_name_input">
            </div>
            <div class="form-group">
                <label for="account_number_input" >Номер Л/С</label>

                <input class="form-control"  type="text" name="account_number" value="${account.account_number!}" placeholder="Номер Л/С" id="account_number_input">
            </div>
            <div class="form-group">
                <label for="account_address_input" >Адрес помещения  по  Л/С</label>

                <input class="form-control"   type="text" name="account_address" value="${account.account_address!}" placeholder="Адрес помещения  по  Л/С" id="account_address_input">
            </div>
            <div class="form-group">
                <label for="lastname_input" >Фамилия</label>

                <input class="form-control"  type="text" name="lastname" value="${account.lastname!}" placeholder="Фамилия" id="lastname_input">
            </div>
            <div class="form-group">
                <label for="firstname_input" >Имя</label>

                <input class="form-control"  type="text" name="firstname" value="${account.firstname!}" placeholder="Имя" id="firstname_input">
            </div>
            <div class="form-group">
                <label for="patronymic_input" >Отчество</label>
                <input class="form-control"   type="text" name="patronymic" value="${account.patronymic!}" placeholder="Отчество" id="patronymic_input">
            </div>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>

</@c.page>
