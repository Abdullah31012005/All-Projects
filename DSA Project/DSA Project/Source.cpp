#include<iostream>
#include<string>
using namespace std;

int size = 0;

class Patient
{
public:
	string name;
	int id;
	string cell;
	string address;
	int age;
public:
	Patient()
	{
		name = "";
		id = 0;
		address = "";
		age = 0;
		cell = "";
	}
	Patient(string name, int id, string cell, string address, int age)
	{
		this->name = name;
		this->id = id;
		this->address = address;
		this->cell = cell;
		this->age = age;
	}
	void display()
	{
		cout << "Name: " << name << endl;
		cout << "Address: " << address << endl;
		cout << "Age: " << age << endl;
		cout << "Cell: " << cell << endl;
		cout << "Id: " << id << endl;
	}
	string getName() {
		return name;
	}
	string getAdd() {
		return address;
	}
	int getId() {
		return id;
	}
	string getCell() {
		return cell;
	}
	int getAge() {
		return age;
	}
	void setName(string name) {
		this->name = name;
	}
	void setId(int id) {
		this->id = id;
	}
	void setAge(int age) {
		this->age = age;
	}
	void setCell(string cell) {
		this->cell = cell;
	}
	void setAddress(string address) {
		this->address = address;
	}
};

Patient p;
class Node : public Patient {
public:
	Node* next;
	Node() : Patient() {
		next = NULL;
	}
	Node(string name, int id, string cell, string address, int age)
		: Patient(name, id, cell, address, age) {
		next = NULL;
	}
};

class Linkedlist {
public:
	Node* head;
	Linkedlist() { head = NULL; }
	void insertNode(string, int, string, string, int);
	void deleteNode(int);
	bool isEmpty();
	bool check(int id)
	{
		Node* temp = head;
		while (temp != NULL)
		{
			if (temp->id == id)
			{
				return true;
			}
			temp = temp->next;
		}
		return false;
	}
};
void Linkedlist::insertNode(string name, int id, string cell, string address, int age)
{
	Node* newNode = new Node(name, id, cell, address, age);
	if (head == NULL) {
		head = newNode;
		return;
	}
	Node* temp = head;
	while (temp->next != NULL) {
		temp = temp->next;
	}
	temp->next = newNode;
}
void Linkedlist::deleteNode(int id) {
	if (head == NULL) {
		return;
	}

	if (head->id == id) {
		Node* temp = head;
		head = (head)->next;
		delete temp;
	}
	Node* current = head;
	while (current != NULL) {
		if (current->next != NULL && current->next->id == id) {
			Node* temp = current->next;
			current->next = current->next->next;
			delete temp;
		}
		else {
			current = current->next;
		}
	}
}

bool Linkedlist::isEmpty() {
	if (head == NULL) {
		return true;
	}
	return false;
}


class Stack {
	Node* top;
public:
	Stack() {
		top = NULL;
	}

	bool isEmpty() {
		if (top == NULL) {
			return true;
		}
		return false;
	}

	void push(string name, int id, string cell, string address, int age) {
		Node* newNode = new Node(name, id, cell, address, age);
		if (isEmpty()) {
			top = newNode;
			return;
		}
		newNode->next = top;
		top = newNode;

	}

	Node* pop() {

		if (isEmpty()) {
			cout << "Stack is Empty!!" << endl;
			return NULL;
		}
		Node* popped = top;
		top = top->next;
		popped->next = NULL;
		return popped;
	}

	void displayStack()
	{

		if (top == NULL)
		{
			cout << "Stack underflow" << endl;
			return;
		}
		Node* current = top;
		while (current != NULL) {

			cout << current->name << " ";
			cout << current->id << " ";
			cout << current->age << " ";
			cout << current->cell << " ";
			cout << current->address << " ";
			cout << endl;
			current = current->next;
		}
	}
};

Linkedlist l1;
Stack s;
void regist()
{
	string name, cell, address;
	int id, age;
	cout << "enter name: " << endl;
	getline(cin.ignore(), name);
	cout << "enter age: " << endl;
	cin >> age;
	cout << "enter id: " << endl;
	cin >> id;
	if (l1.check(id))
	{
		cout << "this id already exists!?" << endl;
		system("cls");
	}
	else {
		cout << "enter cell: " << endl;
		getline(cin.ignore(), cell);
		cout << "enter address: " << endl;
		getline(cin.ignore(), address);
		l1.insertNode(name, id, cell, address, age);
		s.push(name, id, cell, address, age);
		cout << "Record saved successfully!" << endl;
		system("cls");
		p.setName(name);
		p.setAge(age);
		p.setCell(cell);
		p.setId(id);
		p.setAddress(address);
	}
}

void deleteData() {
	int id;
	cout << "Enter Id: " << endl;
	cin >> id;

	l1.deleteNode(id);

	Stack tempStack;
	while (!s.isEmpty()) {
		Node* node = s.pop();
		if (node->getId() != id) {
			tempStack.push(node->getName(), node->getId(), node->getCell(), node->getAdd(), node->getAge());
		}
		delete node;
	}
	while (!tempStack.isEmpty()) {
		Node* node = tempStack.pop();
		s.push(node->getName(), node->getId(), node->getCell(), node->getAdd(), node->getAge());
		delete node;
	}
}

void display()
{
	s.displayStack();
	system("pause");
	system("cls");
}
int main()
{
	string user;
	int tries = 3;
	int pass;
	int flag = 0;
	do {
		cout << "enter username" << endl;
		cin >> user;
		cout << "enter password" << endl;
		cin >> pass;
		if (user == "Admin" && pass == 123)
		{
			cout << "login successful!" << endl;
			system("pause");
			system("cls");
			flag = 1;
			break;
		}
		else
		{
			cout << "login failed!" << endl;
			tries--;
			if (tries == 0)
			{
				exit(0);
			}
			cout << "you have " << tries << " tries left!" << endl;

		}
	} while (flag == 0);
	int c = 0;
	int ch;
	if (flag == 1)
	{
		do
		{
			cout << "\t\t\twellcome to hospital management system!" << endl;
			cout << "press 1 to register new patient!" << endl;
			cout << "press 2 to display record" << endl;
			cout << "press 3 to delete patient record!" << endl;
			cout << "press 4 to exit!" << endl;
			cin >> ch;
			switch (ch)
			{
			case 1:
				system("cls");
				regist();
				c++;
				break;
			case 2:
				system("cls");
				display();
				c++;
				break;
			case 3:
				system("cls");
				deleteData();
				break;
			case 4:
				system("cls");
				exit(0);
			default:
				cout << "invalid choice!" << endl;
				system("cls");
				c++;
				break;
			}
		} while (c > 0);
	}
	return 0;
}