import {SType} from '../components/types';

function Header({name,type}: SType) {
  return (
    <>
        <h1>{name}</h1>
        <h3>{type}</h3>
    </>
  )
}

export default Header