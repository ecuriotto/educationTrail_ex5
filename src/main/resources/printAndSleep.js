
 function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}

console.log(`a1 - Start time --> ${new Date().toISOString()}`);
sleep(2000);
console.log(`a1 - End time --> ${new Date().toISOString()}`);