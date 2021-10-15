from task import Task
from bisect import bisect_left


# Using this binary_search method to replace the Collections.binarySearch in java
def binary_search(task_list, task):
    i = bisect_left(task_list, task)
    if i != len(task_list) and task_list[i] == task:
        return i
    else:
        return -1


class TaskService:
    task_list = []

    def add_task(self, task_id, task_name, task_description):
        new_task = Task(task_id, task_name, task_description)
        i = self.get_index(new_task)
        if i < 0 \
                and self.validate_id(new_task.get_task_id()) \
                and self.validate_name(new_task.get_task_name()) \
                and self.validate_description(new_task.get_task_description()):
            self.task_list.append(new_task)
            return True
        else:
            return False

    def delete_task(self, task_id):
        del_task = Task(task_id, '', '')
        i = self.get_index(del_task)
        if i >= 0:
            del self.task_list[i]

    def update_task(self, task):
        # Search for the input task through against the task list
        for task_obj in self.task_list:
            if task_obj == task and self.validate_name(task.get_task_name()) and self.validate_description(
                    task.get_task_description()):
                # Once we found the task update the name and description fields
                task_obj.set_task_name(task.get_task_name())
                task_obj.set_task_description(task.get_task_description())

    def get_index(self, task):
        i = binary_search(self.task_list, task)
        return i

    # For consistency I redid all validations in this class (but return a bool instad of the exception)
    def validate_id(self, task_id):
        if task_id is not None and len(task_id) < 11:
            return True
        return False

    def validate_name(self, task_name):
        if task_name is not None and len(task_name) < 21:
            return True
        return False

    def validate_description(self, task_description):
        if task_description is not None and len(task_description) < 51:
            return True
        return False
