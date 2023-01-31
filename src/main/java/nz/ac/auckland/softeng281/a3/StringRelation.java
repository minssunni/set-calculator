package nz.ac.auckland.softeng281.a3;

//*******************************
//YOU SHOULD MODIFY THIS CLASS FOR TASK2, TASK3, TASK4, TASK5, and TASK6.
//- you can add all the methods that you need.
//- you cannot modify the method signature (return type, method name and parameters) of the existing methods
//- you can change the code of the existing methods but at your own risk! the program might not work properly
//*******************************

/**
 * A class for binary relations over a set of strings.
 *
 * @author Partha Roop
 */
public class StringRelation extends SetOfStrings {
	// This is a set used to store the members of the binary relation
	private SetOfStrings setMembers;

	/**
	 * create an empty StringRelation when no arguments are given -- constructor In
	 * this event the setMembers is a new SetOfStrings with no members yet
	 */
	public StringRelation() {
		this(new SetOfStrings());
	}

	/**
	 * create a StringRelation object
	 */
	public StringRelation(SetOfStrings setMembers) {
		super();
		this.setMembers = setMembers;
	}

	public void setSetMemberElements(SetOfStrings set) {
		setMembers = set;
	}

	public boolean isValid() {
		SetOfStrings product = setMembers.product(setMembers);
		return product.isSupersetOf(this);
	}

	// checks for a reflexive relation.
	// a relation is reflexive if every element in the setMembers set is connected
	// to itself (i.e has a self loop). returns true is relation is reflexive.
	public boolean isReflexive() {
		if (!isValid()) {
			return false;
		} else if (isEmpty()) {
			// empty sets are not reflexive
			return false;
		} else {

			int i;
			String relation;

			// loop through each element in the setMembers set
			for (i = 0; i < setMembers.size(); i++) {

				// self loop
				relation = setMembers.getElements().get(i) + "," + setMembers.getElements().get(i);

				// check if each element is connected to itself (i.e has a self loop).
				// if there is at least one element that is not connected to itself,
				// the relation is not reflexive.
				if (!isMember(relation)) {
					return false;
				}

			}
			// if all the elements in the setMembers set is connected to itself,
			// the relation is reflexive.
			return true;
		}

	}

	// checks for a symmetric relation.
	// a relation is symmetric if there exists an edge from one vertex to another
	// (v1 to v2) and
	// also an edge in the opposite direction (v2 to v1). returns true is relation
	// is symmetric.
	public boolean isSymmetric() {
		if (!isValid()) {
			return false;
		} else if (isEmpty()) {
			// empty sets are symmetric
			return true;
		} else {

			int i, j;
			String relation1, relation2;

			// loop through each element in the setMembers set for the first vertex (v1)
			for (i = 0; i < setMembers.size(); i++) {
				// loop through each element in the setMembers set for the second vertex (v2)
				for (j = i; j < setMembers.size(); j++) {

					// edge from v1 to v2
					relation1 = setMembers.getElements().get(i) + "," + setMembers.getElements().get(j);
					// edge from v2 to v1
					relation2 = setMembers.getElements().get(j) + "," + setMembers.getElements().get(i);

					// check if there is an edge from v1 to v2 and and edge from v2 to v1.
					// if there exists an edge from v1 to v2 such that an edge from v2 to v1
					// doesn't exist, the relation is not symmetric
					if (isMember(relation1) && !isMember(relation2)) {
						return false;
					} else if (!isMember(relation1) && isMember(relation2)) {
						return false;
					}

				}
			}
			// if for all edges from v1 to v2, there exists also an edge from v2 to v1,
			// the relation is symmetric.
			return true;
		}

	}

	// checks for a transitive relation.
	// a relation is transitive if there exists an edge from vertices v1 to v2 and
	// another edge from
	// v2 to v3, there must also be an edge from v1 to v3. returns true is relation
	// is transitive.
	public boolean isTransitive() {
		if (!isValid()) {
			return false;
		} else if (isEmpty()) {
			// empty sets are transitive
			return true;
		} else {

			int i, j, k;
			String relation1, relation2, relation3;

			// loop through each element in the setMembers set for the first vertex v1
			for (i = 0; i < setMembers.size(); i++) {
				// loop through each element in the setMembers set for the second vertex v2
				for (j = 0; j < setMembers.size(); j++) {
					// loop through each element in the setMembers set for the third vertex v3
					for (k = 0; k < setMembers.size(); k++) {

						// edge from v1 to v2
						relation1 = setMembers.getElements().get(i) + "," + setMembers.getElements().get(j);
						// edge from v2 to v3
						relation2 = setMembers.getElements().get(j) + "," + setMembers.getElements().get(k);
						// edge from v1 to v3
						relation3 = setMembers.getElements().get(i) + "," + setMembers.getElements().get(k);

						// check if there is an edge from v1 to v2 and and edge from v2 to v3.
						// if there exists an edge from v1 to v2 and an edge from v2 to v3
						// but not from v1 to v3, the relation is not symmetric
						if (isMember(relation1) && isMember(relation2) && !isMember(relation3)) {
							return false;
						}
					}
				}
			}
			// if for all cases where there is an edge from v1 to v2 and an edge from v2 to
			// v3
			// there exists also an edge from v1 to v3, the relation in transitive.
			return true;
		}
	}

	// checks for an equivalence relation.
	// a relation is equivalence if the relation is reflexive, symmetric and
	// transitive.
	// returns true is relation is an equivalence relation and false if not.
	public boolean isEquivalence() {
		if (isReflexive() && isSymmetric() && isTransitive()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * do not change this method
	 * 
	 * @param node
	 * @return
	 */
	public SetOfStrings eqClass(String node) {
		if (!isEquivalence()) {
			System.out.println("Can't compute equivalence class.. NOT an equivalence relation");
			return new SetOfStrings();
		}
		return computeEqClass(node);
	}

	// returns the equivalence class of a given node (vertex).
	// the equivalence class of a vertex is the set of all vertices that are
	// connected to the given input node.
	public SetOfStrings computeEqClass(String node) {

		int i;
		String relation;
		SetOfStrings eqClass = new SetOfStrings();

		// loop through each element in the setMembers set
		for (i = 0; i < setMembers.size(); i++) {
			relation = node + "," + setMembers.getElements().get(i);

			// if the given node is connected to the current element in the setMembers set,
			// add this element into the equivalence class
			if (isMember(relation)) {
				eqClass.insertElement(setMembers.getElements().get(i));
			}

		}
		return eqClass;
	}
}