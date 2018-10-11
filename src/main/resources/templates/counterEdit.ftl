<#import "parts/common.ftl" as c>

<@c.page>
<#if action == "new">
<H2>Создание счетчика в Л/С № ${account.account_number! }</H2>
<form action="/account/${account.id!}/counter/add" method="post"  class="container"  >
</#if>
<#if action == "edit">
<H2>Редактирование счетчика  ${account.account_number! }</H2>
<form action="/account/${account.id!}/counter/save" method="post"  class="container"  >
</#if>
            <div class="form-group">
                <label for="counter_name_input" >Наименование счетчика ( напр. Водоканал)</label>

                <input class="form-control" type="text" name="counter_name" value="${count.name!}" placeholder="Наименование счетчика " id="counter_name_input">
            </div>
            <div class="form-group">
                <label for="counter_unit_input" >Единица измерения показаний счетчика</label>
                <input class="form-control" type="text" name="counter_unit" value="${count.unit!}" placeholder="Единица измерения показаний счетчика" id="counter_unit_input">
            </div>

            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>

</@c.page>
