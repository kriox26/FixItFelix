package grafica.dinamica.personajes;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class Felix extends GGO {
	private BufferedImage aloneRunL1, aloneRunL2, aloneRunR1, aloneRunR2, basicStanding, cakeLStanding, cakeRStanding, happyStanding;

	/*
	 * Para cada situacion de movimiento hay un par de imagenes asignado.
	 * Las dos imagenes deben alternar entre si en la situacion asignada.
	 *
	 * aloneRunL1 & aloneRunL2 - corre hacia la izquierda (L de left) sin martillo (guardado)
	 * aloneRunR1 & aloneRunR2 - corre hacia la derecha (R de right) sin martillo (guardado)
	 * basicStanding - parado normalmente sin martillo
	 * happyStanding - parado feliz con el martillo reluciente
	 * cakeLStanding - con tarta a su izquierda (L de left)
	 * cakeRStanding - con tarta a su derecha (R de right)
	 */

	public Felix (int xParam, int yParam) {
		this.setX(xParam);
		this.setY(yParam);
		this.setIP("src/grafica/imagenes/felix/");
		this.uploadImages();
	}

	public void uploadImages(){
		try {
			if (aloneRunL1 == null) {
				aloneRunL1 = this.up("a_runNoAxe_left_1.png");
			}
			if (aloneRunL2 == null) {
				aloneRunL2 = this.up("a_runNoAxe_left_2.png");
			}
			if (aloneRunR1 == null) {
				aloneRunR1 = this.up("a_runNoAxe_right_1.png");
			}
			if (aloneRunR2 == null) {
				aloneRunR2 = this.up("a_runNoAxe_right_2.png");
			}
			if (basicStanding == null) {
				basicStanding = this.up("a_standing_basic.png");
			}
			if (cakeLStanding == null) {
				cakeLStanding = this.up("a_standing_cake_left.png");
			}
			if (cakeRStanding == null) {
				cakeRStanding = this.up("a_standing_cake_right.png");
			}
			if (happyStanding == null) {
				happyStanding = this.up("a_standing_happy.png");
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
