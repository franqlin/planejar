/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.planejar.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import web.planejar.modelo.AcessoPermissao;

/**
 *
 * @author fssantos
 */
@Stateless
public class AcessoPermissaoFacade extends AbstractFacade<AcessoPermissao> {
    @PersistenceContext(unitName = "web.planejar_moduloweb_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcessoPermissaoFacade() {
        super(AcessoPermissao.class);
    }
    
}
