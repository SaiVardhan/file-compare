package com.filematcher.model;

public class PersonName {
	private String firstName;
	private String[] middleName;
	private String lastName;

	public PersonName(String completeName) {
		String[] nameTokens = completeName.split(" ");
		if (nameTokens.length == 2) { // means no middle name
			firstName = nameTokens[0];
			lastName = nameTokens[1];
		} else if (nameTokens.length >= 3) { // means one or more middle name
			firstName = nameTokens[0];
			lastName = nameTokens[nameTokens.length - 1];
			middleName = new String[nameTokens.length - 2];
			for (int i = 1; i <= nameTokens.length - 2; i++) {
				middleName[i - 1] = nameTokens[i];
			}
		} else { // means only first name
			firstName = nameTokens[0];
		}
	}

	public String toString() {
		String middleNameStr = "";
		if (middleName != null) {
			for (String middleNameToken : middleName) {
				middleNameStr = middleNameToken + " ";
			}
			return firstName + " " + middleNameStr + lastName;
		} else {
			return firstName + " " + lastName;
		}
	}

	public boolean equals(Object matcherPerson) {
		boolean result = false;
		if (matcherPerson instanceof PersonName) {
			PersonName matcherName = (PersonName) matcherPerson;
			if (this.firstName.equalsIgnoreCase(matcherName.getFirstName())
					&& !(null != this.lastName ^ null != matcherName
							.getLastName())
					&& (null == lastName || this.lastName
							.equalsIgnoreCase(matcherName.getLastName()))) {
				result = true;
			}

		}
		return result;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String[] getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String[] middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
