import React from "react";
import { Form, Field } from "react-final-form";
import { TextField, Checkbox, Radio, Select } from "final-form-material-ui";
import {
  Typography,
  Paper,
  Grid,
  Button,
  CssBaseline,
  RadioGroup,
  FormLabel,
  MenuItem,
  FormGroup,
  FormControl,
  FormControlLabel
} from "@material-ui/core";
import uuid from "uuidv4";

const validate = values => {
  const errors = {};
  if (!values.firstName) {
    errors.firstName = "Required";
  }
  if (!values.lastName) {
    errors.lastName = "Required";
  }
  return errors;
};

const questionsMap = {
  painter: {
    id: 1,
    label: "painter",
    answer: "artist"
  },
  ceramics: {
    id: 2,
    label: "ceramics",
    answer: "artist"
  },
  forensicArtist: {
    id: 3,
    label: "Forensic Artist",
    answer: "artist"
  },
  programmer: {
    id: 4,
    label: "To build Web site ",
    answer: "programmer"
  },
  AiProgrammer: {
    id: 5,
    label: "AiProgrammer",
    answer: "programmer"
  },
  videoGameProgrammer: {
    id: 6,
    label: "videoGameProgrammer",
    answer: "programmer"
  },
  collegeProffesor: {
    id: 7,
    label: "collegeProffesor",
    answer: "Teacher"
  },
  gradeTeacher: {
    id: 8,
    label: "gradeTeacher",
    answer: "Teacher"
  },
  MathTeacher: {
    id: 9,
    label: "MathTeacher",
    answer: "Teacher"
  },
  EnglishTeacher: {
    id: 10,
    label: "EnglishTeacher",
    answer: "Teacher"
  },
  pharmacist: {
    id: 11,
    label: "pharmacist",
    answer: "Doctor"
  },
  surgeon: {
    id: 12,
    label: "surgeon",
    answer: "Doctor"
  },
  doctor: {
    id: 13,
    label: "doctor",
    answer: "Doctor"
  },
  nurse: {
    id: 14,
    label: "nurse",
    answer: "Doctor"
  },
  nurse: {
    id: 15,
    label: "nurse",
    answer: "Doctor"
  },
  proficiency: {
    id: 16,
    label: "proficiency",
    answer: "I am so good at it"
  },
  influenced: {
    id: 17,
    label: "influenced",
    answer: "Influenced by some one"
  },
  helpingPeople: {
    id: 18,
    label: "helpingPeople",
    answer: "It will help people"
  },
  unsure: {
    id: 19,
    label: "unsure",
    answer: "I don't know"
  }
};

const roles = {
  programmer: ["programmer", "AiProgrammer", "videoGameProgrammer"],
  artist: ["painter", "ceramics", "forensicArtist"],
  teacher: [
    "gradeTeacher",
    "MathTeacher",
    "collegeProffesor",
    "EnglishTeacher"
  ],
  medicalProfessional: ["nurse", "doctor", "surgeon", "pharmacist"]
};

const Questions = ({
  firstName = "",
  lastName = "",
  grade = "",
  Ocupation = "",
  role = [],
  influence = [],
  notes = ""
}) => {
  const questions = [];
  role.forEach(
    r =>
      roles[Ocupation] &&
      roles[Ocupation].includes(r) &&
      questions.push(questionsMap[r])
  );

  influence.includes("unsure")
    ? questions.push(questionsMap["unsure"])
    : influence.forEach(i => questions.push(questionsMap[i]));

  return {
    userId: uuid(),
    firstName,
    lastName,
    grade,
    questions
  };
};

const Ocupations = {
  programmer: [
    {
      label: "To build websites",
      value: "programmer"
    },
    {
      label: "Video game programmer",
      value: "videoGameProgrammer"
    },
    {
      label: "Artificial Intelligence programmer",
      value: "AiProgrammer"
    }
  ],
  teacher: [
    {
      label: "Elemntery Teacher",
      value: "gradeTeacher"
    },
    {
      label: "Professor",
      value: "collegeProffesor"
    },
    {
      label: "English Teacher",
      value: "EnglishTeacher"
    },
    {
      label: "Math Teacher",
      value: "MathTeacher"
    }
  ],
  artist: [
    {
      label: "Painter",
      value: "painter"
    },
    {
      label: "Ceramic Artists",
      value: "ceramics"
    },
    {
      label: "Forensic Artist",
      value: "forensicArtist"
    }
  ],
  medicalProfessional: [
    {
      label: "Nurse",
      value: "nurse"
    },
    {
      label: "Doctor",
      value: "doctor"
    },
    {
      label: "Surgeon",
      value: "surgeon"
    },
    {
      label: "Pharmacist",
      value: "pharmacist"
    }
  ]
};

function App() {
  let d = {};
  const onSubmit = async values => {
    const body = Questions(values);
    console.log(body);
    const response = await fetch(
      "http://34.225.162.67:8080/api/userRecommendations",
      {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify(body)
      }
    );
    console.log(JSON.stringify(response));
    const data = await response.json();
    d = data;
    console.log(JSON.stringify(data));
  };
  return (
    <div style={{ padding: 16, margin: "auto", maxWidth: 600 }}>
      <CssBaseline />
      <Typography variant="h4" align="center" component="h1" gutterBottom>
        Career Interest{" "}
        <span role="img" aria-label="light bulb">
          💡
        </span>
      </Typography>
      <Typography variant="h5" align="center" component="h2" gutterBottom>
        Student Growth Measure by Interest
      </Typography>
      <Typography paragraph>
        <Typography variant="h6" align="center" component="h5" gutterBottom>
          Please contact your parent or teacher for help
        </Typography>
      </Typography>
      <Form
        onSubmit={onSubmit}
        validate={validate}
        render={({ handleSubmit, reset, submitting, pristine, values }) => (
          <form onSubmit={handleSubmit} noValidate>
            <Paper style={{ padding: 16 }}>
              <Grid container alignItems="flex-start" spacing={2}>
                <Grid item xs={6}>
                  <Field
                    fullWidth
                    required
                    name="firstName"
                    component={TextField}
                    type="text"
                    label="First Name"
                  />
                </Grid>
                <Grid item xs={6}>
                  <Field
                    fullWidth
                    required
                    name="lastName"
                    component={TextField}
                    type="text"
                    label="Last Name"
                  />
                </Grid>
                <Grid item xs={6}>
                  <Field
                    fullWidth
                    required
                    name="grade"
                    component={TextField}
                    type="text"
                    label="Grade"
                  />
                </Grid>
                <Grid item>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      What do you want to be when you grow up?
                    </FormLabel>
                    <RadioGroup row>
                      <FormControlLabel
                        label="Artist"
                        control={
                          <Field
                            name="Ocupation"
                            component={Radio}
                            type="radio"
                            value="artist"
                          />
                        }
                      />
                      <FormControlLabel
                        label="Programmer"
                        control={
                          <Field
                            name="Ocupation"
                            component={Radio}
                            type="radio"
                            value="programmer"
                          />
                        }
                      />
                      <FormControlLabel
                        label="Teacher"
                        control={
                          <Field
                            name="Ocupation"
                            component={Radio}
                            type="radio"
                            value="teacher"
                          />
                        }
                      />
                      <FormControlLabel
                        label="Medical Professional"
                        control={
                          <Field
                            name="Ocupation"
                            component={Radio}
                            type="radio"
                            value="medicalProfessional"
                          />
                        }
                      />
                    </RadioGroup>
                  </FormControl>
                </Grid>
                <Grid item>
                  <FormControl component="fieldset">
                    {values.Ocupation && (
                      <FormLabel component="legend">
                        What kind of {values.Ocupation} do you want to be
                      </FormLabel>
                    )}
                    {values.Ocupation && (
                      <FormGroup row>
                        {Ocupations[values.Ocupation].map(
                          ({ label, value }) => (
                            <FormControlLabel
                              label={label}
                              control={
                                <Field
                                  name="role"
                                  component={Checkbox}
                                  type="checkbox"
                                  value={value}
                                />
                              }
                            />
                          )
                        )}
                      </FormGroup>
                    )}
                  </FormControl>
                </Grid>

                {values.Ocupation && values.role && values.role.length > 0 && (
                  <Grid item xs={12}>
                    <FormControl component="fieldset">
                      <FormLabel component="legend">
                        What has influenced you to make this decision?
                      </FormLabel>
                      <FormGroup row>
                        {[
                          {
                            label: "Family",
                            value: "influenced"
                          },
                          {
                            label: "I am so good at it",
                            value: "proficiency"
                          },
                          {
                            label: "It will help people",
                            value: "helpingPeople"
                          },
                          {
                            label: "I don't know",
                            value: "unsure"
                          }
                        ].map(({ label, value }) => (
                          <FormControlLabel
                            label={label}
                            control={
                              <Field
                                name="influence"
                                component={Checkbox}
                                type="checkbox"
                                value={value}
                                disabled={
                                  label === "I don't know"
                                    ? false
                                    : values.influence &&
                                      values.influence &&
                                      values.influence.includes("unsure")
                                }
                              />
                            }
                          />
                        ))}
                      </FormGroup>
                    </FormControl>
                  </Grid>
                )}

                {values.Ocupation &&
                  values.role &&
                  values.role.length > 0 &&
                  values.influence &&
                  values.influence.length > 0 && (
                    <Grid item xs={12}>
                      <Field
                        fullWidth
                        name="notes"
                        component={TextField}
                        multiline
                        label="What do you do today to get your goal"
                      />
                    </Grid>
                  )}
                {/* 
                <Grid item style={{ marginTop: 16 }}>
                  <Button
                    type="button"
                    variant="contained"
                    onClick={reset}
                    disabled={submitting || pristine}
                  >
                    Reset
                  </Button>
                </Grid> */}
                <Grid item style={{ marginTop: 16 }}>
                  <Button
                    variant="contained"
                    color="primary"
                    type="submit"
                    disabled={submitting}
                    onClick={() => onSubmit(values)}
                  >
                    Submit
                  </Button>
                </Grid>
              </Grid>
            </Paper>
            <pre>{JSON.stringify(Questions(values), 0, 2)}</pre>
            <pre>{JSON.stringify(d, 0, 2)}</pre>
          </form>
        )}
      />
    </div>
  );
}

export default App;
