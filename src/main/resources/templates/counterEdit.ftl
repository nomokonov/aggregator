<#import "parts/common.ftl" as c>

<@c.page>
<#if action == "new">
<H2>Создание счетчика в Л/С № ${account.account_number! }</H2>
<form action="/account/${account.id!}" method="post"  class="container"  >
</#if>
<#if action == "edit">
<H2>Редактирование счетчика  ${account.account_number! }</H2>
<form action="/account/${account.id!}/counter/add" method="post"  class="container"  >
</#if>
            <div class="form-group">
                <label for="count_name_input" >Наименование счетчика ( напр. Водоканал)</label>

                <input class="form-control"  type="text" name="count_name" value="${count.name!}" placeholder="Наименование счетчика " id="count_name_input">
            </div>
            <div class="form-group">
                <label for="count_unit_input" >Единица измерения показаний счетчика</label>
                <input class="form-control"  type="text" name="count_unit" value="${count.unit!}" placeholder="Единица измерения показаний счетчика" id="count_unit_input">
            </div>

            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>

</@c.page>
