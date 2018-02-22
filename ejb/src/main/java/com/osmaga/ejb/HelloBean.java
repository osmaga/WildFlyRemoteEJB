/**
 * 
 */
package com.osmaga.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author osmaga
 *
 */
@Stateless
@Remote (HelloRemote.class)
public class HelloBean implements HelloRemote {

	@Override
	public String hello() {
		return "Hello World!";
	}

}
