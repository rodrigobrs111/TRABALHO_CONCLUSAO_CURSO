<%@ page import="teste_12.Produto" %>



			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'nome', 'error')} ">
				<label for="nome" class="control-label"><g:message code="produto.nome.label" default="Nome" /></label>
				<div class="controls">
					<g:textField name="nome" value="${produtoInstance?.nome}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'nome', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'pedido', 'error')} required">
				<label for="pedido" class="control-label"><g:message code="produto.pedido.label" default="Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="pedido" name="pedido.id" from="${teste_12.Pedido.list()}" optionKey="id" required="" value="${produtoInstance?.pedido?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'pedido', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'preco', 'error')} required">
				<label for="preco" class="control-label"><g:message code="produto.preco.label" default="Preco" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="preco" step="any" required="" value="${produtoInstance.preco}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'preco', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'quantidade', 'error')} required">
				<label for="quantidade" class="control-label"><g:message code="produto.quantidade.label" default="Quantidade" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="quantidade" required="" value="${produtoInstance.quantidade}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'quantidade', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste1', 'error')} ">
				<label for="teste1" class="control-label"><g:message code="produto.teste1.label" default="Teste1" /></label>
				<div class="controls">
					<g:textField name="teste1" value="${produtoInstance?.teste1}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste1', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste10', 'error')} ">
				<label for="teste10" class="control-label"><g:message code="produto.teste10.label" default="Teste10" /></label>
				<div class="controls">
					<g:textField name="teste10" value="${produtoInstance?.teste10}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste10', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste11', 'error')} ">
				<label for="teste11" class="control-label"><g:message code="produto.teste11.label" default="Teste11" /></label>
				<div class="controls">
					<g:textField name="teste11" value="${produtoInstance?.teste11}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste11', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste12', 'error')} ">
				<label for="teste12" class="control-label"><g:message code="produto.teste12.label" default="Teste12" /></label>
				<div class="controls">
					<g:textField name="teste12" value="${produtoInstance?.teste12}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste12', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste13', 'error')} ">
				<label for="teste13" class="control-label"><g:message code="produto.teste13.label" default="Teste13" /></label>
				<div class="controls">
					<g:textField name="teste13" value="${produtoInstance?.teste13}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste13', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste14', 'error')} ">
				<label for="teste14" class="control-label"><g:message code="produto.teste14.label" default="Teste14" /></label>
				<div class="controls">
					<g:textField name="teste14" value="${produtoInstance?.teste14}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste14', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste15', 'error')} ">
				<label for="teste15" class="control-label"><g:message code="produto.teste15.label" default="Teste15" /></label>
				<div class="controls">
					<g:textField name="teste15" value="${produtoInstance?.teste15}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste15', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste16', 'error')} ">
				<label for="teste16" class="control-label"><g:message code="produto.teste16.label" default="Teste16" /></label>
				<div class="controls">
					<g:textField name="teste16" value="${produtoInstance?.teste16}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste16', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste17', 'error')} ">
				<label for="teste17" class="control-label"><g:message code="produto.teste17.label" default="Teste17" /></label>
				<div class="controls">
					<g:textField name="teste17" value="${produtoInstance?.teste17}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste17', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste18', 'error')} ">
				<label for="teste18" class="control-label"><g:message code="produto.teste18.label" default="Teste18" /></label>
				<div class="controls">
					<g:textField name="teste18" value="${produtoInstance?.teste18}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste18', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste19', 'error')} ">
				<label for="teste19" class="control-label"><g:message code="produto.teste19.label" default="Teste19" /></label>
				<div class="controls">
					<g:textField name="teste19" value="${produtoInstance?.teste19}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste19', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste2', 'error')} ">
				<label for="teste2" class="control-label"><g:message code="produto.teste2.label" default="Teste2" /></label>
				<div class="controls">
					<g:textField name="teste2" value="${produtoInstance?.teste2}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste2', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste20', 'error')} ">
				<label for="teste20" class="control-label"><g:message code="produto.teste20.label" default="Teste20" /></label>
				<div class="controls">
					<g:textField name="teste20" value="${produtoInstance?.teste20}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste20', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste3', 'error')} ">
				<label for="teste3" class="control-label"><g:message code="produto.teste3.label" default="Teste3" /></label>
				<div class="controls">
					<g:textField name="teste3" value="${produtoInstance?.teste3}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste3', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste4', 'error')} ">
				<label for="teste4" class="control-label"><g:message code="produto.teste4.label" default="Teste4" /></label>
				<div class="controls">
					<g:textField name="teste4" value="${produtoInstance?.teste4}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste4', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste5', 'error')} ">
				<label for="teste5" class="control-label"><g:message code="produto.teste5.label" default="Teste5" /></label>
				<div class="controls">
					<g:textField name="teste5" value="${produtoInstance?.teste5}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste5', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste6', 'error')} ">
				<label for="teste6" class="control-label"><g:message code="produto.teste6.label" default="Teste6" /></label>
				<div class="controls">
					<g:textField name="teste6" value="${produtoInstance?.teste6}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste6', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste7', 'error')} ">
				<label for="teste7" class="control-label"><g:message code="produto.teste7.label" default="Teste7" /></label>
				<div class="controls">
					<g:textField name="teste7" value="${produtoInstance?.teste7}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste7', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste8', 'error')} ">
				<label for="teste8" class="control-label"><g:message code="produto.teste8.label" default="Teste8" /></label>
				<div class="controls">
					<g:textField name="teste8" value="${produtoInstance?.teste8}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste8', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: produtoInstance, field: 'teste9', 'error')} ">
				<label for="teste9" class="control-label"><g:message code="produto.teste9.label" default="Teste9" /></label>
				<div class="controls">
					<g:textField name="teste9" value="${produtoInstance?.teste9}"/>
					<span class="help-inline">${hasErrors(bean: produtoInstance, field: 'teste9', 'error')}</span>
				</div>
			</div>

