public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		return Math.sqrt(Math.pow(xxPos-p.xxPos,2)+Math.pow(yyPos-p.yyPos,2));
	}
	public double calcForceExertedBy(Planet p){
		return 6.67*Math.pow(10,-11)*mass*p.mass/Math.pow(calcDistance(p),2);
	}
	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p)*(p.xxPos-xxPos)/calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p)*(p.yyPos-yyPos)/calcDistance(p);
	}
	public void update(double period_time, double ForceExertedByX,double ForceExertedByY){
		xxVel = xxVel + ForceExertedByX/mass*period_time;
		yyVel = yyVel + ForceExertedByY/mass*period_time;
		xxPos = xxPos + xxVel*period_time;
		yyPos = yyPos + yyVel*period_time;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}