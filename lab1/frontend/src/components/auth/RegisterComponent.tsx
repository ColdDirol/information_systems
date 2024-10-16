import { useState } from "react";
import { Button, Form, Modal, Nav, SelectPicker } from "rsuite";
import PageEndIcon from "@rsuite/icons/PageEnd";
import { RoleEnum } from "../../intefaces/userInterface";

const selectData = Object.entries(RoleEnum).map(([value]) => ({
  label: value,
  value: value,
}));

export default function RegisterComponent() {
  const [open, setOpen] = useState(false);
  const [formValue, setFormValue] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    console.log("sign up");
    setOpen(true);
  };

  const handleFormChange = (value: any) => {
    setFormValue(value);
  };

  const handleRegister = () => {
    console.log("register: data sent");
    setOpen(false);
  };

  return (
    <>
      <Nav.Item icon={<PageEndIcon />} onClick={handleOpen}>
        Sign up
      </Nav.Item>
      <Modal open={open} onClose={handleClose} size="xs">
        <Modal.Header>
          <Modal.Title>Sign up</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form fluid onChange={handleFormChange} formValue={formValue}>
            <Form.Group controlId="name-9">
              <Form.ControlLabel>Username</Form.ControlLabel>
              <Form.Control placeholder="name" name="name" />
            </Form.Group>
            <Form.Group controlId="email-9">
              <Form.ControlLabel>Email</Form.ControlLabel>
              <Form.Control placeholder="email" name="email" type="email" />
            </Form.Group>
            <Form.Group controlId="password-9">
              <Form.ControlLabel>Password</Form.ControlLabel>
              <Form.Control
                placeholder="password"
                name="password"
                type="password"
                autoComplete="off"
              />
            </Form.Group>
            <Form.Group controlId="select-10">
              <Form.ControlLabel>SelectPicker</Form.ControlLabel>
              <Form.Control
                placeholder="choose role"
                name="select"
                data={selectData}
                accepter={SelectPicker}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={handleRegister} appearance="primary">
            Confirm
          </Button>
          <Button onClick={handleClose} appearance="subtle">
            Cancel
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
