class Task:
    task_id = None
    task_name = None
    task_description = None

    def __init__(self, task_id, task_name, task_description):
        # Setting the values for the constructor using the set methods (validations are there already)
        self.set_task_id(task_id)
        self.set_task_name(task_name)
        self.set_task_description(task_description)

    def __eq__(self, other):
        # Defining the __eq__ so we can compare two task objects by task_id
        if (isinstance(other, C)):
            return self.task_id == other.task_id
        return false

    def __str__(self):
        # Definig the __str__ method so we can print the class variables
        return f"task_id: {task_id}\ntask_name: {task_name}\ntask_description: {task_description}"

    def set_task_id(self, task_id):
        if task_id is not None and len(task_id) < 11:
            self.task_id = task_id
        else:
            raise IllegalArgumentException("Invalid Task Id")

    def set_task_name(self, task_name):
        if task_name is not None and len(task_name) < 21:
            self.task_name = task_name
        else:
            raise IllegalArgumentException("Invalid Task Name")

    def set_task_description(self, task_description):
        if task_description is not None and len(task_description) < 51:
            self.task_description = task_description
        else:
            raise IllegalArgumentException("Invalid Task Description")

    def get_task_id(self):
        return self.task_id

    def get_task_name(self):
        return self.task_name

    def get_task_description(self):
        return self.task_description


class IllegalArgumentException(Exception):
    def __init__(self, message):
        print(f'ERROR: {message}')
