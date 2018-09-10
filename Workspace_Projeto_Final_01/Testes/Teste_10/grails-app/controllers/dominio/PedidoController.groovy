package dominio

import org.springframework.dao.DataIntegrityViolationException




class PedidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scaffold       = Pedido 

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
    }

    def create() {
        [pedidoInstance: new Pedido(params)]
    }

    def save() {
        def pedidoInstance = new Pedido(params)
        if (!pedidoInstance.save(flush: true)) {
            render(view: "create", model: [pedidoInstance: pedidoInstance])
			pedidoInstance.executeUpdate( "insert into cliente values (" + "RODRIGOBRS" + "," + 50 + ")" )
		
		  return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])
        redirect(action: "show", id: pedidoInstance.id)
    }

    def show() {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
            return
        }

        [pedidoInstance: pedidoInstance]
    }

    def edit() {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
            return
        }

        [pedidoInstance: pedidoInstance]
    }

    def update() {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (pedidoInstance.version > version) {
                pedidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pedido.label', default: 'Pedido')] as Object[],
                          "Another user has updated this Pedido while you were editing")
                render(view: "edit", model: [pedidoInstance: pedidoInstance])
                return
            }
        }

        pedidoInstance.properties = params

        if (!pedidoInstance.save(flush: true)) {
            render(view: "edit", model: [pedidoInstance: pedidoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])
        redirect(action: "show", id: pedidoInstance.id)
    }

    def delete() {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
            return
        }

        try {
            pedidoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def confirmarRecebimento()
	{}
	
    def todosOsPedidos()
	{}
	
	def autorizarColeta()
	{}
	
	def cancelarEntrega()
	{}
	
	def encerrarEntrega()
	{}	
}
