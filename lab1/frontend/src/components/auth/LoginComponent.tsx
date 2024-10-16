import { useState } from "react";
import { Button, Form, Modal, Nav } from "rsuite";
import PageEndIcon from "@rsuite/icons/PageEnd";

export default function LoginComponent() {
  const [open, setOpen] = useState(false);
  const [formValue, setFormValue] = useState({
    email: "",
    password: "",
  });

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    console.log("log in");
    setOpen(true);
  };

  const handleFormChange = (value: any) => {
    setFormValue(value);
  };

  const handleLogin = () => {
    console.log("login: data sent");
    setOpen(false);
  };

  return (
    <>
      <Nav.Item icon={<PageEndIcon />} onClick={handleOpen}>
        Log in
      </Nav.Item>
      <Modal open={open} onClose={handleClose} size="xs">
        <Modal.Header>
          <Modal.Title>Log in</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form fluid onChange={handleFormChange} formValue={formValue}>
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
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={handleLogin} appearance="primary">
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
