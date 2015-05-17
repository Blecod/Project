package lt.ktu.project.client;



public enum SortType {
	DATE("date"), RELEVANCE("relevance"), POPULARITY("populiarity");
	private String name;
	
	SortType(String name){
		 this.name = name;
		}
		public String toString(){
		  return name;
		}
}
