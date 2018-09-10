package extra

import org.springframework.dao.DataIntegrityViolationException

class RelatorioController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scafoold       = true
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [relatorioInstanceList: Relatorio.list(params), relatorioInstanceTotal: Relatorio.count()]
    }

    def create() {
        [relatorioInstance: new Relatorio(params)]
    }

    def save() {
        def relatorioInstance = new Relatorio(params)
        if (!relatorioInstance.save(flush: true)) {
            render(view: "create", model: [relatorioInstance: relatorioInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), relatorioInstance.id])
        redirect(action: "show", id: relatorioInstance.id)
    }

    def show(Long id) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        [relatorioInstance: relatorioInstance]
    }

    def edit(Long id) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        [relatorioInstance: relatorioInstance]
    }

    def update(Long id, Long version) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (relatorioInstance.version > version) {
                relatorioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'relatorio.label', default: 'Relatorio')] as Object[],
                          "Another user has updated this Relatorio while you were editing")
                render(view: "edit", model: [relatorioInstance: relatorioInstance])
                return
            }
        }

        relatorioInstance.properties = params

        if (!relatorioInstance.save(flush: true)) {
            render(view: "edit", model: [relatorioInstance: relatorioInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), relatorioInstance.id])
        redirect(action: "show", id: relatorioInstance.id)
    }

    def delete(Long id) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        try {
            relatorioInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def visualizarRelatorios()
	{}
	
}
