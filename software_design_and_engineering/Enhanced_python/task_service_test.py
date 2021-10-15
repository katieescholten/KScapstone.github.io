import unittest
from task_service import TaskService
from task import Task


class TestTaskService(unittest.TestCase):
    test_id = "0123456789"
    test_name = "TaskName<21"
    test_description = "Description<51"

    def test_task_service(self):
        update_task = Task("2223456789", "UpdateName", "UpdateDescription")
        task_service = TaskService()
        task_service.add_task("2223456789", self.test_name, self.test_description)
        task_service.add_task(self.test_id, self.test_name, self.test_description)
        task_service.delete_id(self.test_id)

        task_service.update_task(update_task)
        self.assertEquals(update_task.get_task_id(), "2223456789")
        self.assertEquals(update_task.get_task_name(), "UpdateName")
        self.assertEquals(update_task.get_task_description(), "UpdateDescription")
