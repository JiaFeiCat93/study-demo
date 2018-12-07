package com.qetch.effectivejava.item2;

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder {//Builder pattern
		//Required parameters
		private final int servingSize;
		private final int servings;
		
		//Optional parameters - initialized to default values
		private int calories     = 0;
		private int fat 	 	 = 0;
		private int sodium   	 = 0;
		private int carbohydrate = 0; 
		
		public Builder(int servingSize, int serving) {
			this.servingSize = servingSize;
			this.servings = serving;
		} 
		
		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}
		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}
		public Builder sodium(int sodium) {
			this.sodium = sodium;
			return this;
		}
		public Builder carbohydrate(int carbohydrate) {
			this.carbohydrate = carbohydrate;
			return this;
		}
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}

	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(12, 13)
				.calories(14)
//				.fat(15)
//				.sodium(16)
				.carbohydrate(17)
				.build();
		System.out.println(nutritionFacts);
	}
}
