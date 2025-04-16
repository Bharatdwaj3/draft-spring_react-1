import {SType} from '../components/types';

function About({name,type}: SType) {
  return (
    <>
        <h1>{name}</h1>
        <h3>{type}</h3>
    </>
  )
}

export default About