package com.amit.sample.model;

public class Customer {
	
	private String name;
    private int age;
    private String email;
    private Long id;

    
    public Customer(Long id, String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.id = id;
	}
    
	public Customer() {
		super();
	}


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
