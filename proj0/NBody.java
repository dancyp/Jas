//import java.awt.*;
public class NBody{
	public static double readRadius(String filename){
		In inputstream = new In(filename);
		int nums = inputstream.readInt();
		return inputstream.readDouble();
	}
	public static Planet[] readPlanets(String filename){
		In inputstream = new In(filename);
		int nums = inputstream.readInt();
		double Raidius = inputstream.readDouble();
		Planet[] planets = new Planet[nums];
		int i=0;
		while(i<nums){
			double xxpos = inputstream.readDouble();
			double yypos = inputstream.readDouble();
			double xxvel = inputstream.readDouble();
			double yyvel = inputstream.readDouble();
			double mass = inputstream.readDouble();
			String imgstring = inputstream.readString();
			planets[i++] = new Planet(xxpos,yypos,xxvel,yyvel,mass,imgstring);
		}

		return planets;
	}
	public static void main(String []args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = NBody.readRadius(filename);
		Planet []planets = NBody.readPlanets(filename);


		//Draw
		double radius = readRadius(filename);
		String imageBackground = "images/starfield.jpg";
		//background
		StdDraw.setScale(-radius,radius);
		// StdDraw.clear();
		StdDraw.picture(0,0,imageBackground);

		int nums = planets.length;
		int i  = 0;
		for(i=0;i<nums;i++){
			planets[i].draw();
		}

		double timestep = 0;
		StdAudio.play("audio/2001.mid");
		while(true){
			double []xForces = new double[nums];
			double []yForces = new double[nums];

			for(i = 0;i<nums;i++){
				for(int j = 0;j<nums;j++){
					if(j == i){
						continue;
					}
					xForces[i] += planets[i].calcForceExertedByX(planets[j]);
					yForces[i] += planets[i].calcForceExertedByY(planets[j]);
				}
			}

			for(i = 0;i<nums;i++){
				planets[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0,0,imageBackground);
			for(i = 0;i<nums;i++){
				planets[i].draw();
			}
			
			StdDraw.show(10);



			if((timestep += dt)>=T){
				timestep = 0;
				StdOut.printf("%d\n", planets.length);
				StdOut.printf("%.2e\n", radius);
				for (i = 0; i < planets.length; i++) {
					StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				   		planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
				}	
				
			}

		}
	}


}
