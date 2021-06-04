//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.06.03 a las 05:40:03 PM CEST 
//

package com.practica.xml.fruteria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para anonymous complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="variante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "variante" })
@XmlRootElement(name = "FrutaNombreVarianteResponse")
public class FrutaNombreVarianteResponse {

	@XmlElement(required = true)
	protected String variante;

	/**
	 * Obtiene el valor de la propiedad variante.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVariante() {
		return variante;
	}

	/**
	 * Define el valor de la propiedad variante.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setVariante(String value) {
		this.variante = value;
	}

}
